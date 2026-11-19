class Turf {
  final int id;
  final String name;
  final String location;
  final String sportType;
  final double pricePerHour;

  Turf({
    required this.id,
    required this.name,
    required this.location,
    required this.sportType,
    required this.pricePerHour,
  });

  factory Turf.fromJson(Map<String, dynamic> json) {
    return Turf(
      id: json['id'],
      name: json['name'],
      location: json['location'],
      sportType: json['sportType'],
      pricePerHour: (json['pricePerHour'] as num).toDouble(),
    );
  }
}

