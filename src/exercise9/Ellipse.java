package exercise9;

public class Ellipse {
    private Point startPoint;
    private double semiAxisA;
    private double semiAxisB;

    public Ellipse(){
        startPoint = new Point(0,0);
        semiAxisA = 1;
        semiAxisB = 1;
    }
    public Ellipse(Point startPoint, double semiAxisA, double semiAxisB){
        this.startPoint = new Point(startPoint);
        this.semiAxisA = semiAxisA;
        this.semiAxisB = semiAxisB;
    }
    public Ellipse(Ellipse otherEllipse){
        startPoint = new Point(otherEllipse.startPoint);
        semiAxisA = otherEllipse.semiAxisA;
        semiAxisB = otherEllipse.semiAxisB;
    }
    private boolean isValid(){
        return semiAxisA > 0 && semiAxisB > 0;
    }
    public void initialize(){
        do {
            System.out.println("Start point: ");
            startPoint.initialize();
            System.out.println("Enter semi axis a: ");
            semiAxisA = Utils.INPUT.nextDouble();
            System.out.println("Enter semi axis b: ");
            semiAxisB = Utils.INPUT.nextDouble();
        }while(!isValid());
    }
    public double calculatePerimeter(){
        double perimeter = Math.PI*(3*(semiAxisA + semiAxisB) - Math.sqrt((3*semiAxisA + semiAxisB)*(semiAxisA + 3*semiAxisB)));
        return perimeter;
    }
    public double calculateArea(){
        double area = Math.PI * semiAxisA * semiAxisB;
        return area;
    }
    public String getType(){
        if(semiAxisA == semiAxisB){
            return "Cycle";
        }else{
            return  "Ellipse";
        }
    }
    public String toString(){
        return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, semiAxisA, semiAxisB, getType(), calculatePerimeter(), calculateArea());
    }
    public boolean equals(Ellipse otherEllipse){
        boolean same = Utils.equals(this.semiAxisA, otherEllipse.semiAxisA) && Utils.equals(this.semiAxisB, otherEllipse.semiAxisB);
        boolean reversed = Utils.equals(this.semiAxisA, otherEllipse.semiAxisB) && Utils.equals(this.semiAxisB, otherEllipse.semiAxisA);
        return same || reversed;
    }
}
