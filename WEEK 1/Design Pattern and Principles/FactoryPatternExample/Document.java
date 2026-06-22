interface Document{
    void open();
}
class WordDocument implements Document{
    @Override
    public void open(){
        System.out.println("Opening word Document");
    }
}

class PdfDocument implements Document{
    @Override
    public void open(){
        System.out.println("Opeing Pdf Document");
    }
}

class ExcelDocument implements Document{
    @Override
    public void open(){
        System.out.println("Opening Excel Document");
    }
}