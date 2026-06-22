interface Documenent{
    void open();
}
class WordDocument implements Document{
    @override
    public void open(){
        System.out.println("Opening word Document");
    }
}

class PdfDocument implements Document{
    @override
    public void open(){
        System.out.println("Opeing Pdf Document");
    }
}

class ExcelDocument implements Document{
    @override
    public void open(){
        System.out.println("Opening Excel Document");
    }
}