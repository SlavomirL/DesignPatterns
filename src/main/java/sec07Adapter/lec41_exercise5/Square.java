package sec07Adapter.lec41_exercise5;


/*Adapter Coding Exercise
Here's a very synthetic example for you to try.

You are given a Rectangle  interface and an extension method on it. Try to define a SquareToRectangleAdapter  that adapts the Square  to the IRectangle  interface.*/

class Square
{
    public int side;

    public Square(int side)
    {
        this.side = side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

/* this is commented out only so that i can compile code in future lectures
class SquareToRectangleAdapter implements Rectangle
{
    public SquareToRectangleAdapter(Square square)
    {
        // todo
    }
}
*/
