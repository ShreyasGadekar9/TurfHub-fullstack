class Slot {
  final int id;
  final String date;
  final String startTime;
  final String endTime;
  final bool booked;

  Slot({
    required this.id,
    required this.date,
    required this.startTime,
    required this.endTime,
    required this.booked,
  });

  factory Slot.fromJson(Map<String, dynamic> json) {
    return Slot(
      id: json['id'],
      date: json['date'],
      startTime: json['startTime'],
      endTime: json['endTime'],
      booked: json['booked'],
    );
  }
}
