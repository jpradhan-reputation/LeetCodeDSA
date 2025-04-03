package jp.dsa.array;

public class RodsVsRings {

    public static int countPoints(String rings) {
        int rgbRings = 0;
        String[] rodsVsRings = new String[10];
        for (int i = 0; i < rings.length(); i++) {
            char ringColour = rings.charAt(i);
            int rodIndex = Integer.parseInt(String.valueOf(rings.charAt(++i)));

            String ringColours = rodsVsRings[rodIndex];
            if (ringColours != null) {
                rodsVsRings[rodIndex] = ringColours + ringColour;
            } else {
                rodsVsRings[rodIndex] = String.valueOf(ringColour);
            }
        }

        for (String rodVsRings: rodsVsRings) {
            if (rodVsRings != null && (rodVsRings.contains("R") && rodVsRings.contains("G") && rodVsRings.contains("B"))) {
                rgbRings++;
            }
        }
        return rgbRings;
    }

    public static void main(String[] args) {
        String rings = "B9R9G0R4G9";
        int rgbRings = countPoints(rings);
        System.out.println("RGB rings count: " + rgbRings);
    }
}