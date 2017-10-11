package exercise3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

public class Exercise3Test {
	@Test
	public void computeSquarePerimeter() {
		ConvexPolygon square = buildSquare();
		double perimeter = Exercise3.computePerimeter(square);
		assertThat(perimeter).isCloseTo(80.0, withinPercentage(1));
	}

	@Test
	public void computeRectanglePerimeter() {
		ConvexPolygon rectangle = buildRectangle();
		double perimeter = Exercise3.computePerimeter(rectangle);
		assertThat(perimeter).isCloseTo(80.0, withinPercentage(1));
	}

	@Test
	public void computePolygonPerimeter() {
		ConvexPolygon hexagon = buildHexagon();
		double perimeter = Exercise3.computePerimeter(hexagon);
		assertThat(perimeter).isCloseTo(20.0 + 4.0 * Math.sqrt(50.0), withinPercentage(1));
	}

	@Test
	public void computeSquareArea() {
		ConvexPolygon square = buildSquare();
		double area = Exercise3.computeArea(square);
		assertThat(area).isCloseTo(400, withinPercentage(1));
	}

	@Test
	public void computeRectangleArea() {
		ConvexPolygon rectangle = buildRectangle();
		double area = Exercise3.computeArea(rectangle);
		assertThat(area).isCloseTo(300.0, withinPercentage(1));
	}

	@Test
	public void computePolygonArea() {
		ConvexPolygon hexagon = buildHexagon();
		double area = Exercise3.computeArea(hexagon);
		assertThat(area).isCloseTo(150.0, withinPercentage(1));
	}

	@Test
	public void computeEllipsisPerimeter() {
		Ellipsis ellipsis = buildEllipsis();
		double perimeter = Exercise3.computePerimeter(ellipsis);
		assertThat(perimeter).isCloseTo(2.0 * Math.PI * Math.sqrt(1450.0), withinPercentage(1));
	}

	@Test
	public void computeCirclePerimeter() {
		Ellipsis circle = buildCircle();
		double perimeter = Exercise3.computePerimeter(circle);
		assertThat(perimeter).isCloseTo(24.0 * Math.PI, withinPercentage(1));
	}

	@Test
	public void computeCircleArea() {
		Ellipsis circle = buildCircle();
		double area = Exercise3.computeArea(circle);
		assertThat(area).isCloseTo(Math.PI * 144.0, withinPercentage(1));
	}

	@Test
	public void computeEllipsisArea() {
		Ellipsis ellipsis = buildEllipsis();
		double area = Exercise3.computeArea(ellipsis);
		assertThat(area).isCloseTo(Math.PI * 100.0, withinPercentage(1));
	}

	private ConvexPolygon buildSquare() {
		return Exercise3.buildSquare(new Point(18, 24), 20);
	}

	private ConvexPolygon buildRectangle() {
		return Exercise3.buildRectangle(new Point(5, 5), new Point(15, -25));
	}

	private ConvexPolygon buildHexagon() {
		Point[] hexagonVertices = new Point[]{
			new Point(0, 0),
			new Point(10, 0),
			new Point(15, 5),
			new Point(10, 10),
			new Point(0, 10),
			new Point(-5, 5)
		};
		return Exercise3.buildConvexPolygon(hexagonVertices);
	}

	private Ellipsis buildCircle() {
		return Exercise3.buildCircle(new Point(-5, 25), 12);
	}

	private Ellipsis buildEllipsis() {
		Point center = new Point(10, 10);
		return Exercise3.buildEllipsis(center, 20, 50);
	}

}
