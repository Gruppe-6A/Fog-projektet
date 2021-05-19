package business.services;

public class SVG {
    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String headerTemplate = "<svg height=\"%d\" " +
            "width=\"%d\" " +
            "viewBox=\"%s\" "+
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            "preserveAspectRatio=\"xMinYMin\">";

    private final String rectTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final String lineTemplate = "<g stroke=\"black\" stroke-width=\"4\"><path stroke-dasharray=\"5,5\" d=\"M%d %d l%d %d\" />";
    private final String defs = "<defs> <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\"> <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" /> </marker> <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\"> <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" /> </marker> </defs>";
    private final String arrowLine = "<line x1=\"%f\"  y1=\"%f\" x2=\"%f\"   y2=\"%f\" \n" +
            "\tstyle=\"stroke: #000000;\n" +
            "\tmarker-start: url(#beginArrow);\n" +
            "\tmarker-end: url(#endArrow);\"/>";
    private final String textTemplate = "<text style=\"text-anchor: middle\" transform=\"translate(%f,%f) rotate(%f)\">%s</text>";

    public SVG(int x, int y, String viewBox, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y ));
    }

    public void addDefs(){
        svg.append(defs);
    }

    public  void addText(double x, double y, double rotation, String text){
        svg.append(String.format(textTemplate, x, y, rotation, text));
    }

    public void addArrowLine(double x1, double y1, double x2, double y2){
        svg.append(String.format(arrowLine, x1, y1, x2, y2));
    }

    public void addRect(double x, double y, double height, double width)
    {
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addLine(int x1, int y1, int x2, int y2 )
    {
        svg.append(String.format(lineTemplate, x1, y1, x2, y2));
    }

    public void addSvg(SVG innerSVG)
    {
        svg.append(innerSVG.toString());
    }

    @Override
    public String toString()
    {
        return svg.toString() + "</svg>" ;
    }
}
