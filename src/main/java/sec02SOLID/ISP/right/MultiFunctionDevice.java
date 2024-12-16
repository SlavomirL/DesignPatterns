package sec02SOLID.ISP.right;

import sec02SOLID.ISP.Document;

public class MultiFunctionDevice implements  MultiFunctionMachine {
    private Printer printer;
    private Scanner scanner;

    public MultiFunctionDevice(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}
