package sec02SOLID.ISP.wrong;

import sec02SOLID.ISP.Document;

// even though that this client wants old printer that was supposed to print only, it has to implement all the other methods anyway
public class OldFashionedPrinter implements Machine {
    @Override
    public void fax(Document d) {
        //own implementation for fax is NOK in this case
    }

    @Override
    public void print(Document d) {
//own implementation for print is fine in this case
    }

    @Override
    public void scan(Document d) {
//own implementation for scan is NOK in this case
    }
}
