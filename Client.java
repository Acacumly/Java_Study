package test33;

public class Client
{
    public static void main6(String args[])
    {
        EncryptFacade ef=new EncryptFacade();
        ef.fileEncrypt("First.txt", "Second.txt");
    }
}
