
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog3-short_log");
        read.printAll();
    }

    public void testUniqueIP(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog2_log");
        System.out.println("There are " + read.countUniqueIPs()+ " different IPs");
    }

    public void testStatusCodeHigherThanNum(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog1_log");
        System.out.println("Higher than 400: ");
        read.printAllHigherThanNum(400);
    }

    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog2_log");
        read.countUniqueIPs();
        ArrayList a = read.uniqueIPVisitsOnDay("Sep 24");
        System.out.println("Unique visits on Sep 24: "+a.size());
    }

    public void testCountUniqueIPsInRange(){
        LogAnalyzer read = new LogAnalyzer();
        read.readFile("weblog2_log");
        System.out.println("Between 200 and 299 "+read.countUniqueIPsInRange(200,299));
    }

    public static void main(String[] args){
        Tester t= new Tester();
        t.testLogAnalyzer();
        t.testLogEntry();
        t.testUniqueIP();
        t.testCountUniqueIPsInRange();
        t.testStatusCodeHigherThanNum();
        t.testUniqueIPVisitsOnDay();
    }
}