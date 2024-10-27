public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private double slope;
    private double distance;
    private String equation;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        slope = 0.0;
        distance = 0.0;
    }

    public double slope() {
        if ((x2 - x1) == 0) {
            return Double.NaN;
        }
        slope = (double) (y2 - y1) / (x2 - x1);
        return roundedToHundredth(slope);
    }

    public double distance() {
        distance = Math.sqrt((Math.pow((double) (x2 - x1), 2) + (Math.pow((double) (y2 - y1), 2))));
        return roundedToHundredth(distance);
    }

    public double yIntercept() {
        double i = (double) y1 - (slope() * x1);
        return roundedToHundredth(i);
    }

    public String equation() {
        int y = (y2 - y1);
        int x = (x2 - x1);
        if (Double.isNaN(slope())) {
            if (x1 == x2) {
                return "x = " + x1;
            } else if (y1 == y2) {
                return "y = " + y1;
            }
        }
        if (x < 0) {
            int newX = Math.abs(x);
            y *= -1;
            if (y % x == 0) {
                if (yIntercept() < 0) {
                    double newYInt = Math.abs(yIntercept());
                    if ((double) y / newX == 1) {
                        return "y = x - " + newYInt;
                    } else if ((double) y / newX == -1) {
                        return "y = -x - " + newYInt;
                    }
                    return "y = " + y / newX + "x - " + newYInt;
                } else if (yIntercept() == 0) {
                    if ((double) y / newX == 1) {
                        return "y = x";
                    } else if ((double) y / newX == -1) {
                        return "y = -x";
                    }
                    return "y = " + y / newX + "x";
                } else {
                    if ((double) y / newX == 1) {
                        return "y = x + " + yIntercept();
                    } else if ((double) y / newX == -1) {
                        return "y = -x + " + yIntercept();
                    }
                    return "y = " + y / newX + "x + " + yIntercept();
                }
            } else {
                if (yIntercept() < 0) {
                    double newYInt = Math.abs(yIntercept());
                    return "y = " + y + "/" + newX + "x - " + newYInt;
                } else if (yIntercept() == 0) {
                    return "y = " + y + "/" + newX + "x";
                } else {
                    return "y = " + y + "/" + newX + "x + " + yIntercept();
                }
            }
        } else {
            if (y % x == 0) {
                if (yIntercept() < 0) {
                    double newYInt = Math.abs(yIntercept());
                    if ((double) y / x == 1) {
                        return "y = x - " + newYInt;
                    } else if ((double) y / x == -1) {
                        return "y = -x - " + newYInt;
                    }
                    return "y = " + y / x + "x - " + newYInt;
                } else if (yIntercept() == 0) {
                    if ((double) y / x == 1) {
                        return "y = x";
                    } else if ((double) y / x == -1) {
                        return "y = -x";
                    }
                    return "y = " + y / x + "x";

                } else {
                    if ((double) y / x == 1) {
                        return "y = x + " + yIntercept();
                    } else if ((double) y / x == -1) {
                        return "y = -x - " + yIntercept();
                    }
                    return "y = " + y / x + "x + " + yIntercept();
                }
            } else {
                if (yIntercept() < 0) {
                    double newYInt = Math.abs(yIntercept());
                    if ((double) y / x == 1) {
                        return "y = x - " + newYInt;
                    } else if ((double) y / x == -1) {
                        return "y = -x - " + newYInt;
                    }
                    return "y = " + y + "/" + x + "x - " + newYInt;
                } else if (yIntercept() == 0) {
                    if ((double) y / x == 1) {
                        return "y = x";
                    } else if ((double) y / x == -1) {
                        return "y = -x";
                    }
                    return "y = " + y + "/" + x + "x";
                } else {
                    if ((double) y / x == 1) {
                        return "y = x + " + yIntercept();
                    } else if ((double) y / x == -1) {
                        return "y = -x + " + yIntercept();
                    }
                    return "y = " + y + "/" + x + "x + " + yIntercept();
                }
            }
        }
    }

    public String coordinateForX(double x) {
        return "The point on the line is: (" + x + ", " + ((slope() * x) + yIntercept()) + ")";
    }

    public String lineInfo() {
        String info = "";
        if (!Double.isNaN(slope())) {
            info += "-----Line Info-----\n";
            info += "The two points are: " + "(" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")\n";
            info += "The equation of the line between these points is: " + equation() + "\n";
            info += "The slope of this line is: " + slope() + "\n";
            info += "The y-intercept of this line is: " + yIntercept() + "\n";
            info += "The distance between these points is: " + distance();
        } else {
            if (x1 == x2) {
                info += "These points are on a vertical line: " + equation();
            } else if (y1 == y2) {
                info += "These points are on a horizontal line: " + equation();
            }
        }
        return info;
    }

    private double roundedToHundredth(double toRound) {
        double rounded = Math.round(toRound * 100) / 100.0;
        return rounded;
    }
}