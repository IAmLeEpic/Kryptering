package Sprint1;
/**
 * Created by sjjo15 on 2017-10-04.
 */
public class CMDInput {
    public static void main(String[] args){
        switch (args.length) {
            case 0 :
                noArgument();
                break;
            case 1 :
                oneArgument(args);
                break;
            case 2 :
                twoArguments(args);
                break;
            case 3 :
                threeArguments(args);
                break;
            case 4 :
                fourArguments(args);
                break;
            default :
                help();
        }
    }

    public static void help(){
        System.out.println("Syntax: java args\n" +
                "\tNo arguments - print error message and this text\n" +
                "\tOne arguments - Repeat argument\n" +
                "\tTwo arguments - Add argumnets as numbers\n" +
                "\tThree arguments - Reverse arguments\n" +
                "\tFour arguments - Give up\n"
        );
    }

    public static void noArgument(){
        System.out.println("Programmet vet inte vad det ska göra! Avbryter..");
        help();
    }

    public static void oneArgument(String[] arguments){
        System.out.println("Så du säger " + arguments[0] + "?");
    }

    public static void twoArguments(String[] arguments){
        try {
            System.out.println(Double.parseDouble(arguments[0] + Double.parseDouble(arguments[1])));
        } catch (NumberFormatException e){
            System.out.println(arguments[0] + arguments[0]);
        }
    }

    public static void threeArguments(String[] arguments) {
        for (int i = arguments.length -1 ; i <= 0 ; i--) {
            System.out.print(arguments[i] + " ");
        }
        System.out.print('\n');
    }

    public static void fourArguments(String[] arguments) {
        System.out.println("Jag orkar inte, jag stänger ner");
    }
}
