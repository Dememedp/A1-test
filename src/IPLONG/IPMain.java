package IPLONG;

public class IPMain {
    public static void main(String[] args) {
        System.out.println("IP to Long:\n" + "1. " + IpToLong.ipToLong("128.32.10.0"));
        System.out.println("2. " + IpToLong.ipToLong("0.0.0.255"));
        System.out.println("Long to IP:\n" + "1. " + LongToIp.longToIp(3232235778L));
        System.out.println("2. " + LongToIp.longToIp(255));
    }
}