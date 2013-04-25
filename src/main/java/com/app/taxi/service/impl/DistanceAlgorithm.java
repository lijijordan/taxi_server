package com.app.taxi.service.impl;

public class DistanceAlgorithm {

	private static final double PIx = 3.141592653589793;
	private static final double RADIO = 6378.16;

	public static double Radians(double x) {
		return x * PIx / 180;
	}

	public static double DistanceBetweenPlaces(double lon1, double lat1,
			double lon2, double lat2) {
		
		double dlon = Radians(lon2 - lon1);
		double dlat = Radians(lat2 - lat1);

		double a = (Math.sin(dlat / 2) * Math.sin(dlat / 2))
				+ Math.cos(Radians(lat1)) * Math.cos(Radians(lat2))
				* (Math.sin(dlon / 2) * Math.sin(dlon / 2));
		double angle = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return (angle * RADIO);// distance in km
	}

	public static void main(String[] args) {
		System.out.println(DistanceBetweenPlaces(
				30.658601, 104.064856, 30.626243,104.147644));
	}
}
