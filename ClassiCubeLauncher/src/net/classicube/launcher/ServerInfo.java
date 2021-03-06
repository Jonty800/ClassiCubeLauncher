package net.classicube.launcher;

import java.net.InetAddress;
import java.util.Locale;

// Stores all metadata about a game server
class ServerInfo {
    // Basic info
    public String name;
    public String hash;
    
    // Info from the server list
    public int players;
    public int maxPlayers;
    public String flag;
    public int uptime;
    
    // Info from the play page
    public String pass;
    public InetAddress address;
    public int port;
    
    public static String formatUptime(int seconds) {
        if (seconds < 60) {
            return seconds + "s";
        } else if (seconds < 60 * 60) {
            return (seconds / 60) + "m";
        } else if (seconds < 60 * 60 * 24) {
            return (seconds / (60 * 60)) + "h";
        } else {
            return (seconds / (60 * 60 * 24)) + "d";
        }
    }
    
    public static String toCountryName(String s) {
        Locale l = new Locale("EN", s);
        return l.getDisplayCountry();
    }
}
