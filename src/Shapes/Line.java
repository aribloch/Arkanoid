//Ari Bloch 328792866

package Shapes;

/**
 * this class creates a line object, made from two points.
 */
public class Line {
    private Point start;
    private Point end;
    static final double EPSILON = 1E-10;

    /**
     * this is the constructor that builds and initiates the line
     * object that's being created.
     *
     * @param start a point which will serve as one end of the line.
     * @param end   a point which will serve as the second end of the line.
     */
    // constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * this is another constructor that builds and initiates the line
     * object that's being created.
     *
     * @param x1 a number which will serve as one of the lines ends X coordinate
     * @param y1 a number which will serve as one of the lines ends Y coordinate
     * @param x2 a number which will serve as one of the lines ends X coordinate
     * @param y2 a number which will serve as one of the lines ends Y coordinate
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * this method returns the length of a line.
     *
     * @return the length value
     */
    // Returns the length of the line
    public double length() {
        return this.start.distance(end);
    }

    /**
     * this method calculates and returns the middle of value of a line.
     *
     * @return the middle point value
     */
    // Returns the middle point of the line
    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2;
        double middleY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(middleX, middleY);

    }

    /**
     * this method checks and returns the highest X coordinate of a line.
     *
     * @param line the line being checked
     * @return the maximum X value
     */
    //Returns maximum X
    public double maxX(Line line) {
        return Math.max(line.start.getX(), line.end.getX());
    }

    /**
     * this method checks and returns the highest Y coordinate of a line.
     *
     * @param line the line being checked
     * @return the maximum Y value
     */
    //Returns maximum Y
    public double maxY(Line line) {
        return Math.max(line.start.getY(), line.end.getY());
    }

    /**
     * this method checks and returns the lowest X coordinate of a line.
     *
     * @param line the line being checked
     * @return the minimum X value
     */
    //Returns minimum X
    public double minX(Line line) {
        return Math.min(line.start.getX(), line.end.getX());
    }

    /**
     * this method checks and returns the lowest Y coordinate of a line.
     *
     * @param line the line being checked
     * @return the minimum Y value
     */
    //Returns minimum Y
    public double minY(Line line) {
        return Math.min(line.start.getY(), line.end.getY());
    }

    /**
     * this method returns the "starting" end of a line.
     *
     * @return the "start" of a line.
     */
    // Returns the start point of the line
    public Point start() {
        return start;
    }

    /**
     * this method returns the "end" of a line.
     *
     * @return the other end of a line.
     */
    // Returns the end point of the line
    public Point end() {
        return end;
    }

    /**
     * this method receives a line and calculates its slope.
     *
     * @param line the line that the method calculates its slope
     * @return the value of the slope of the line
     */
    // Returns the slope of any given line
    public double slopeOfLine(Line line) {
        return ((line.start.getY() - line.end.getY()) / (line.start.getX() - line.end.getX()));
    }


    /**
     * this method receives a line and calculates its intersection with Y axis
     * (if it had an infinite length).
     *
     * @param line the line that the method calculates its potential
     *             intersection with Y axis.
     * @return the value of the potential intersection with Y axis.
     */
    //Returns the intersection point of a line with Y (b)
    public double bOfLine(Line line) {
        return (line.start.getY() - (line.slopeOfLine(line) * line.start.getX()));
    }

    /**
     * this method checks if two lines indeed intersect.
     *
     * @param other the line that the method is checking if it
     *              intersects with the current line.
     * @return if the lines intersect (true), false otherwise
     */
    // Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        //checks if the start/end of any line is the same point as the start/end of another line
        if ((this.start.equals(other.start) || this.start.equals(other.end)
                || this.end.equals(other.start)
                || this.end.equals(other.end)) && !(this.equals(other))) {
            return true;
        }
        //checks if two lines are parallel and don't intersect
        if (Math.abs(this.slopeOfLine(this) - other.slopeOfLine(other)) < EPSILON
                && (this.bOfLine(this) != other.bOfLine(other))) {
            return false;
        }
        //checks if 2 lines are both vertical and don't intersect
        if (Math.abs(this.start.getX() - this.end.getX()) < EPSILON && (Math.abs(other.start.getX()
                - other.end.getX()) < EPSILON) && ((this.start.getX() != other.start.getX())
                || (this.minY(this) > other.maxY(other))
                || (other.minY(other) > this.maxY(this)))) {
            return false;
        }

        //both are perpendicular to each other but don't intersect
        if ((Math.abs(this.slopeOfLine(this)) < EPSILON && Math.abs(other.start.getX() - other.end.getX())
                < EPSILON)
                ||
                (Math.abs(other.slopeOfLine(other)) < EPSILON && Math.abs(this.start.getX() - this.end.getX())
                        < EPSILON)) {
            if (Math.abs(this.slopeOfLine(this)) < EPSILON && ((this.maxX(this) < other.start.getX())
                    || (this.minX(this) > other.start.getX()))) {
                return false;
            }
            if (Math.abs(this.slopeOfLine(this)) < EPSILON && (this.start.getY() < other.minY(other)
                    || this.start.getY() > other.maxY(other))) {
                return false;
            }
            if (Math.abs(other.slopeOfLine(other)) < EPSILON && (other.start.getY() < this.minY(this)
                    || other.start.getY() > this.maxY(this))) {
                return false;
            }
            if (Math.abs(other.slopeOfLine(other)) < EPSILON && ((other.minX(other) > this.start.getX())
                    || other.maxX(other) < this.start.getX())) {
                return false;
            }
            if (Math.abs(this.slopeOfLine(this)) < EPSILON && ((this.start.getY() <= other.maxY(other))
                    && (this.start.getY() >= other.minY(other)))
                    && (other.start.getX() >= this.minX(this)) && other.start.getX()
                    <= this.maxX(this)) {
                return true;
            }
        }
        if (Math.abs(other.slopeOfLine(other)) < EPSILON && ((other.start.getY() <= this.maxY(this))
                && (other.start.getY() >= this.minY(this)))
                && (this.start.getX() >= other.minX(other)) && this.start.getX()
                <= other.maxX(other)) {
            return true;
        }


        //checks if one line is vertical and the other isn't if they intersect
        if (Math.abs(this.start.getX() - this.end.getX()) < EPSILON && (this.start.getX() >= other.minX(other))
                && (this.start.getX() <= other.maxX(other)) && ((other.minY(other)
                >= this.minY(this) && other.minY(other) <= this.maxY(this))
                || (other.maxY(other)
                <= this.maxY(this) && other.maxY(other) >= this.minY(this)))) {
            return true;
        }
        if (Math.abs(other.start.getX() - other.end.getX()) < EPSILON && (other.start.getX() >= this.minX(this))
                && (other.start.getX() <= this.maxX(this)) && ((this.minY(this)
                >= other.minY(other) && this.minY(this) <= other.maxY(other)) || (this.maxY(this)
                <= other.maxY(other) && this.maxY(this) >= other.minY(other)))) {
            return true;
        }
        //checks if lines intersect in multiple points
        if (Math.abs(this.slopeOfLine(this) - other.slopeOfLine(other)) < EPSILON
                && Math.abs(this.bOfLine(this) - other.bOfLine(other)) < EPSILON) {
            if ((this.start.getX() < other.maxX(other) && this.start.getX() > other.minX(other))
                    || (this.end.getX() < other.maxX(other) && this.end.getX() > other.minX(other))) {
                return true;
            }
            if (this.equals(other)) {
                return true;
            }
        }
        //checks if 2 lines have a different slope and are not vertical and if they indeed intersect
        double intersectX = (other.bOfLine(other) - this.bOfLine(this))
                / (this.slopeOfLine(this) - other.slopeOfLine(other));
        if (this.slopeOfLine(this) != other.slopeOfLine(other)) {
            return ((intersectX >= this.minX(this)) && (intersectX <= this.maxX(this))
                    && (intersectX >= other.minX(other)) && (intersectX <= other.maxX(other)));
        } else {
            return false;
        }
    }

    /**
     * this method returns the intersection point if the
     * lines intersect,and null otherwise.
     *
     * @param other the other line this method is comparing the current line to.
     * @return returns the intersection point value, or null if
     * lines do not intersect.
     */
    public Point intersectionWith(Line other) {
        if (this.isIntersecting(other)) {
            //checks if 2 lines intersect just at the edge
            if ((this.start.getX() != this.end.getX()
                    && other.start.getX() != other.end.getX())
                    && Math.abs(this.slopeOfLine(this) - other.slopeOfLine(other)) < EPSILON
                    && Math.abs(this.bOfLine(this) - other.bOfLine(other)) < EPSILON
                    && Math.abs(this.maxX(this) - other.minX(other)) < EPSILON
                    || Math.abs(other.maxX(other) - this.minX(this)) < EPSILON) {
                if (this.start.equals(other.start)) {
                    return this.start;
                }
                if (this.start.equals(other.end)) {
                    return this.start;
                }
                if (this.end.equals(other.start)) {
                    return this.end;
                }
                if (this.end.equals(other.end)) {
                    return this.end;
                }
            }
            //checks if lines intersect in multiple places
            if (Math.abs(this.slopeOfLine(this) - other.slopeOfLine(other)) < EPSILON
                    && Math.abs(this.bOfLine(this) - other.bOfLine(other)) < EPSILON) {
                if ((this.start.getX() <= other.maxX(other) && this.start.getX() >= other.minX(other))
                        || (this.end.getX() <= other.maxX(other) && this.end.getX() >= other.minX(other))) {
                    return null;
                }
            }
            if (this.equals(other)) {
                return null;
            }
            //finds intersecting point of two lines that intersect at the edges of the lines
            if (this.start.equals(other.start) && !(this.equals(other))) {
                return this.start;
            }
            if (this.start.equals(other.end) && !(this.equals(other))) {
                return this.start;
            }
            if (this.end.equals(other.start) && !(this.equals(other))) {
                return this.end;
            }
            if (this.end.equals(other.end) && !(this.equals(other))) {
                return this.end;
            }
            //find the intersecting point of one vertical line and one non-vertical line
            if ((Math.abs(other.start.getX() - other.end.getX()) < EPSILON && (this.start.getX() != this.end.getX()))) {
                return new Point(other.start.getX(), (this.slopeOfLine(this) * other.start.getX())
                        + this.bOfLine(this));
            }
            if ((this.start.getX() == this.end.getX()) && (other.start.getX() != other.end.getX())) {
                return new Point(this.start.getX(), (other.slopeOfLine(other) * this.start.getX())
                        + other.bOfLine(other));
            }
            //find the intersecting point of two non-vertical lines
            if ((this.start.getX() != this.end.getX()) && (other.start.getX()
                    != other.end.getX())) {
                double intersectX = (other.bOfLine(other) - this.bOfLine(this))
                        / (this.slopeOfLine(this) - other.slopeOfLine(other));
                return new Point(intersectX, (this.slopeOfLine(this) * intersectX) + this.bOfLine(this));
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    /**
     * This method chekcs if the line does not intersect with the rectangle, it returns null.
     * otherwise, it returns the closest intersection point to the
     * start of the line.
     *
     * @param rect the rectangle that the line might be intersecting.
     * @return closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //checks if line doesn't instersect with the rectangle at all
        if ((!this.isIntersecting(rect.getLeftLine())) && (!this.isIntersecting(rect.getRightLine()))
                && (!this.isIntersecting(rect.getTopLine()))
                && (!this.isIntersecting(rect.getBottomLine()))) {
            return null;
        }
        //checks if line intersects with left and right side of rectangle
        if (this.isIntersecting(rect.getLeftLine()) && this.intersectionWith(rect.getLeftLine())
                != null
                && this.isIntersecting(rect.getRightLine()
        ) && this.intersectionWith(rect.getRightLine()) != null) {
            if (this.intersectionWith(rect.getLeftLine()).distance(this.start)
                    >
                    this.intersectionWith(rect.getRightLine()).distance(this.start)) {
                return this.intersectionWith(rect.getRightLine());
            } else {
                return this.intersectionWith(rect.getLeftLine());
            }
        }
//checks if line intersects with left and top side of rectangle
        if (this.isIntersecting(rect.getLeftLine()) && this.intersectionWith(rect.getLeftLine())
                != null && this.isIntersecting(rect.getTopLine())
                && this.intersectionWith(rect.getTopLine()) != null) {
            if (this.intersectionWith(rect.getLeftLine()).distance(this.start)
                    >
                    this.intersectionWith(rect.getTopLine()).distance(this.start)) {
                return this.intersectionWith(rect.getTopLine());
            } else {
                return this.intersectionWith(rect.getLeftLine());
            }
        }
        //checks if line intersects with left and bottom side of rectangle
        if (this.isIntersecting(rect.getLeftLine()) && this.intersectionWith(rect.getLeftLine())
                != null
                && this.isIntersecting(rect.getBottomLine())
                && this.intersectionWith(rect.getBottomLine()) != null) {
            if (this.intersectionWith(rect.getLeftLine()).distance(this.start)
                    >
                    this.intersectionWith(rect.getBottomLine()).distance(this.start)) {
                return this.intersectionWith(rect.getBottomLine());
            } else {
                return this.intersectionWith(rect.getLeftLine());
            }
        }
        //checks if line intersects with top and bottom side of rectangle
        if (this.isIntersecting(rect.getTopLine()) && this.intersectionWith(rect.getTopLine())
                != null && this.isIntersecting(rect.getBottomLine())
                && this.intersectionWith(rect.getBottomLine())
                != null) {
            if (this.intersectionWith(rect.getTopLine()).distance(this.start)
                    >
                    this.intersectionWith(rect.getBottomLine()).distance(this.start)) {
                return this.intersectionWith(rect.getBottomLine());
            } else {
                return this.intersectionWith(rect.getTopLine());
            }
        }
        //checks if line intersects with top and right side of rectangle
        if (this.isIntersecting(rect.getTopLine()) && this.intersectionWith(rect.getTopLine())
                != null && this.isIntersecting(rect.getRightLine())
                && this.intersectionWith(rect.getRightLine()) != null) {
            if (this.intersectionWith(rect.getTopLine()).distance(this.start)
                    >
                    this.intersectionWith(rect.getRightLine()).distance(this.start)) {
                return this.intersectionWith(rect.getRightLine());
            } else {
                return this.intersectionWith(rect.getTopLine());
            }
        }
        //checks if line intersects with bottom and right side of rectangle
        if (this.isIntersecting(rect.getBottomLine()) && this.intersectionWith(rect.getBottomLine())
                != null && this.isIntersecting(rect.getRightLine())
                && this.intersectionWith(rect.getRightLine()) != null) {
            if (this.intersectionWith(rect.getBottomLine()).distance(this.start)
                    >
                    this.intersectionWith(rect.getRightLine()).distance(this.start)) {
                return this.intersectionWith(rect.getRightLine());
            } else {
                return this.intersectionWith(rect.getBottomLine());
            }
        }
        //checks if intersects with only left line
        if (this.isIntersecting(rect.getLeftLine()) && this.intersectionWith(rect.getLeftLine())
                != null) {
            return this.intersectionWith(rect.getLeftLine());
        }
        //checks if intersects with only right line
        if (this.isIntersecting(rect.getRightLine()) && this.intersectionWith(rect.getRightLine())
                != null) {
            return this.intersectionWith(rect.getRightLine());
        }
        //checks if intersects with only top line
        if (this.isIntersecting(rect.getTopLine()) && this.intersectionWith(rect.getTopLine())
                != null) {
            return this.intersectionWith(rect.getTopLine());
        }
        //checks if intersects with only bottom line
        if (this.isIntersecting(rect.getBottomLine()) && this.intersectionWith(rect.getBottomLine())
                != null) {
            return this.intersectionWith(rect.getBottomLine());
        } else {
            return null;
        }
    }

    /**
     * this method checks if two lines are actually the same line (equal).
     *
     * @param other the other line this method is comparing the current line to.
     * @return if they are two equal lines (true) or not (false).
     */
    // equals -- return true if the lines are equal, false otherwise
    public boolean equals(Line other) {
        return ((this.start.equals(other.start)) && (this.end.equals(other.end)) || (this.start.equals(other.end))
                && (this.end.equals(other.start)));
    }
}


