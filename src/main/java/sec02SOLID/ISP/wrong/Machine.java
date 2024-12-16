package sec02SOLID.ISP.wrong;

import sec02SOLID.ISP.Document;

public interface Machine {
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}
