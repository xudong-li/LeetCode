class Station {
    String stationName;
    int t;
    public Station(String stationName, int t) {
        this.stationName = stationName;
        this.t = t;
    }
}

class TimeInfo {
    int totalTime;
    int count;
    public TimeInfo(int totalTime, int count) {
        this.totalTime = totalTime;
        this.count = count;
    }
}

class UndergroundSystem {

    Map<Integer, Station> stationByIdMap;
    Map<String, TimeInfo> timeByStationsMap;
    
    public UndergroundSystem() {
        stationByIdMap = new HashMap<>();
        timeByStationsMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        stationByIdMap.put(id, new Station(stationName, t));   
    }
    
    public void checkOut(int id, String stationName, int t) {
        Station entrance = stationByIdMap.get(id);
        String key = entrance.stationName + "->" + stationName;
        
        TimeInfo currInfo = timeByStationsMap.getOrDefault(key, new TimeInfo(0,0));
        currInfo.totalTime += (t - entrance.t);
        currInfo.count++;
        
        timeByStationsMap.put(key, currInfo);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        TimeInfo currInfo = timeByStationsMap.get(startStation + "->" + endStation);
        return (double) currInfo.totalTime / (double) currInfo.count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */