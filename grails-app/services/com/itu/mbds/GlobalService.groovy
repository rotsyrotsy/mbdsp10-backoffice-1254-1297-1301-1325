package com.itu.mbds

import grails.gorm.transactions.Transactional
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired

@Transactional
class GlobalService {
    def getStartOfDay() {
        def calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    def getEndOfDay() {
        def calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        return calendar.time
    }

    double toRadians(double degree) {
        return degree * (Math.PI / 180)
    }

    double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371 // Earth's radius in kilometers

        double dLat = toRadians(lat2 - lat1)
        double dLon = toRadians(lon2 - lon1)

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(toRadians(lat1)) * Math.cos(toRadians(lat2)) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2)

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))

        double distance = R * c // Distance in kilometers

        return distance
    }
}

