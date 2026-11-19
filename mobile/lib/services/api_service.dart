import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/turf.dart';
import '../models/slot.dart';
import '../models/user.dart';

class ApiService {
  // Use explicit IPv4 loopback (127.0.0.1) which routes through USB via adb reverse.
  // Do NOT use 'localhost' because Android resolves localhost to IPv6 (::1).
  static String activeBaseUrl = 'http://127.0.0.1:8080';
  static const String wifiBaseUrl = 'http://192.168.1.33:8080';

  static Future<http.Response> _get(String path) async {
    try {
      final res = await http.get(Uri.parse('$activeBaseUrl$path')).timeout(const Duration(seconds: 4));
      return res;
    } catch (_) {
      final fallback = activeBaseUrl.contains('127.0.0.1') ? wifiBaseUrl : 'http://127.0.0.1:8080';
      final res = await http.get(Uri.parse('$fallback$path')).timeout(const Duration(seconds: 4));
      activeBaseUrl = fallback;
      return res;
    }
  }

  static Future<http.Response> _post(String path, Map<String, dynamic> body) async {
    try {
      final res = await http.post(
        Uri.parse('$activeBaseUrl$path'),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode(body),
      ).timeout(const Duration(seconds: 4));
      return res;
    } catch (_) {
      final fallback = activeBaseUrl.contains('127.0.0.1') ? wifiBaseUrl : 'http://127.0.0.1:8080';
      final res = await http.post(
        Uri.parse('$fallback$path'),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode(body),
      ).timeout(const Duration(seconds: 4));
      activeBaseUrl = fallback;
      return res;
    }
  }

  // Register a new user
  static Future<User> register(String name, String email, String password, String phone) async {
    final response = await _post('/api/users/register', {
      'name': name,
      'email': email,
      'password': password,
      'phone': phone,
    });
    if (response.statusCode == 201) {
      return User.fromJson(jsonDecode(response.body));
    } else {
      throw Exception(response.body);
    }
  }

  // Login
  static Future<User> login(String email, String password) async {
    final response = await _post('/api/users/login', {
      'email': email,
      'password': password,
    });
    if (response.statusCode == 200) {
      return User.fromJson(jsonDecode(response.body));
    } else {
      throw Exception(response.body);
    }
  }

  // Get all turfs
  static Future<List<Turf>> getTurfs() async {
    final response = await _get('/api/turfs');
    if (response.statusCode == 200) {
      final List<dynamic> jsonList = jsonDecode(response.body);
      return jsonList.map((json) => Turf.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load turfs');
    }
  }

  // Get available slots for a turf
  static Future<List<Slot>> getAvailableSlots(int turfId) async {
    final response = await _get('/api/turfs/$turfId/slots/available');
    if (response.statusCode == 200) {
      final List<dynamic> jsonList = jsonDecode(response.body);
      return jsonList.map((json) => Slot.fromJson(json)).toList();
    } else if (response.statusCode == 404) {
      return [];
    } else {
      throw Exception('Failed to load slots');
    }
  }

  // Book a slot
  static Future<String> bookSlot(int slotId, String userName) async {
    final response = await _post('/api/bookings', {
      'slotId': slotId,
      'userName': userName,
    });
    if (response.statusCode == 201) {
      return 'CONFIRMED';
    } else {
      throw Exception(response.body);
    }
  }
}
