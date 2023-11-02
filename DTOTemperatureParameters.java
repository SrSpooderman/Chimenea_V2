public class DTOTemperatureParameters {
    private int coolPixelPercentage;
    private int hotPixelPercentage;
    private double[] cellPonderation = new double[6];
    private double cellsDivider;
    private double atenuationFactor;
    private boolean bottomUpTemps;

    public DTOTemperatureParameters(int coolPixelPercentage, int hotPixelPercentage, double[] cellPonderation, double cellsDivider, double atenuationFactor, boolean calculateup) {
        this.coolPixelPercentage = coolPixelPercentage;
        this.hotPixelPercentage = hotPixelPercentage;
        this.cellPonderation = cellPonderation;
        this.cellsDivider = cellsDivider;
        this.atenuationFactor = atenuationFactor;
        this.bottomUpTemps = calculateup;
    }

    public int getCoolPixelPercentage() {
        return coolPixelPercentage;
    }

    public void setCoolPixelPercentage(int coolPixelPercentage) {
        coolPixelPercentage = coolPixelPercentage;
    }

    public int getHotPixelPercentage() {
        return hotPixelPercentage;
    }

    public void setHotPixelPercentage(int hotPixelPercentage) {
        this.hotPixelPercentage = hotPixelPercentage;
    }

    public double[] getCellPonderation() {
        return cellPonderation;
    }

    public void setCellPonderation(double[] cellPonderation) {
        this.cellPonderation = cellPonderation;
    }

    public double getCellsDivider() {
        return cellsDivider;
    }

    public void setCellsDivider(double cellsDivider) {
        this.cellsDivider = cellsDivider;
    }

    public double getAtenuationFactor() {
        return atenuationFactor;
    }

    public void setAtenuationFactor(double atenuationFactor) {
        this.atenuationFactor = atenuationFactor;
    }

    public boolean isBottomUpTemps() {
        return bottomUpTemps;
    }

    public void setBottomUpTemps(boolean bottomUpTemps) {
        this.bottomUpTemps = bottomUpTemps;
    }
}
