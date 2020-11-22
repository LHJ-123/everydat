import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Modify libMod = new Modify();

        libMod.PrintOne(libMod.findNum("002"));
        Library library = new Library("Nihao","解决","hh","jj");
        libMod.addLibrary(library);
    }
}