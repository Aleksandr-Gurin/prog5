package ru.ifmo.se.pult;

import ru.ifmo.se.musicians.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Reader {
    private static File scriptName;
    private static Integer argument;
    private static File startFile;

    public Reader(Scanner in) {
    }

    public static CommandName readCommand(Scanner in) {
        String command = in.nextLine();
        String[] mas = command.split("\\s");
        boolean flag = true;
        CommandName commandName = null;

        if (command.equals("")){
            return CommandName.ERROR;
        }
        for (CommandName cn: CommandName.values()) {
            if (cn.getCommand().equals(mas[0])) {
                commandName = cn;
                flag = false;
                break;
            }
        }
        if (flag){
            return CommandName.ERROR;
        }
        if (mas.length == 1 && (commandName == CommandName.CLEAR || commandName == CommandName.EXIT || commandName == CommandName.REMOVE_LOWER || commandName == CommandName.REMOVE_GREATER || commandName == CommandName.HELP || commandName == CommandName.HISTORY || commandName == CommandName.INFO || commandName == CommandName.PRINT_DESCENDING || commandName == CommandName.SAVE || commandName == CommandName.SHOW || commandName == CommandName.ADD || commandName == CommandName.MAX_BY_GENRE)) {
            return commandName;
        }
        else if(mas.length == 2){
            if (commandName == CommandName.FILTER_LESS_THEN_NUMBER_OF_PARTICIPANTS || commandName == CommandName.REMOVE_BY_ID || commandName == CommandName.UPDATE){
                try {
                    argument = Integer.parseInt(mas[1]);
                    return commandName;
                }
                catch(NumberFormatException e){
                    return CommandName.ERROR;
                }
            }
            else if (commandName == CommandName.EXECUTE_SCRIPT){
                scriptName = new File(mas[1]);
                return commandName;
            }
            else {
                return CommandName.ERROR;
            }
        }
        else{
            return CommandName.ERROR;
        }
    }

    public static int readArgument(){
        return argument;
    }

    public static File readScriptName() {
        return scriptName;
    }

    public static File readFile(Scanner in) {
        System.out.println("Введите путь к файлу: ");
        String path = in.nextLine();
        Scanner file;
        boolean flag = true;
        startFile = new File(path);
        while(flag) {
            try {
                file = new Scanner(startFile);
                flag = false;
            } catch (FileNotFoundException e) {
                System.out.println("Неправильно введен путь повторите попвтку: ");
                path = in.nextLine();
                startFile = new File(path);
            }
        }
        return startFile;
    }

    public static MusicBand readCollectionObject(Scanner in) {
        //name
        System.out.println("Введите имя группы: ");
        String name = in.nextLine();
        if (name.equals("")) {
            while (name.equals("")) {
                System.out.println("Введите корректное имя: ");
                name = in.nextLine();
            }
        }

        //Coordinate x
        System.out.println("Введите координату x: ");
        boolean bool = true;
        long x = 0;
        String s = in.nextLine();
        try {
            x = Long.parseLong(s);
            if (x > 913) {
                while (s.equals("") || bool) {
                    try {
                        x = Long.parseLong(s);
                        if (x > 913) {
                            s = in.nextLine();
                            continue;
                        }
                        bool = false;
                    } catch (NumberFormatException e1) {
                        System.out.println("Координата введена неверно, повторите попытку: ");
                        s = in.nextLine();
                    }
                }
            }
        } catch (NumberFormatException e) {
            while (s.equals("") || bool) {
                try {
                    x = Long.parseLong(s);
                    if (x > 913) {
                        s = in.nextLine();
                        continue;
                    }
                    bool = false;
                } catch (NumberFormatException e1) {
                    System.out.println("Координата введена неверно, повторите попытку: ");
                    s = in.nextLine();
                }
            }
        }

        //Coordinate y
        System.out.println("Введите координату y: ");
        bool = true;
        double y = 0;
        s = in.nextLine();
        try {
            y = Double.parseDouble(s);
            if (y <= -224) {
                while (s.equals("") || bool) {
                    try {
                        y = Double.parseDouble(s);
                        if (y <= -224) {
                            s = in.nextLine();
                            continue;
                        }
                        bool = false;
                    } catch (NumberFormatException e1) {
                        System.out.println("Координата введена неверно, повторите попытку: ");
                        s = in.nextLine();
                    }
                }
            }
        } catch (NumberFormatException e) {
            while (s.equals("") || bool) {
                try {
                    y = Double.parseDouble(s);
                    if (y <= -224) {
                        s = in.nextLine();
                        continue;
                    }
                    bool = false;
                } catch (NumberFormatException e1) {
                    System.out.println("Координата введена неверно, повторите попытку: ");
                    s = in.nextLine();
                }
            }
        }

        //NumberOfParticipants
        System.out.println("Введите количество участников группы: ");
        bool = true;
        int nop = 0;
        s = in.nextLine();
        try {
            nop = Integer.parseInt(s);
            if (nop < 1) {
                while (s.equals("") || bool) {
                    try {
                        nop = Integer.parseInt(s);
                        if (nop < 1) {
                            s = in.nextLine();
                            continue;
                        }
                        bool = false;
                    } catch (NumberFormatException e1) {
                        System.out.println("Координата введена неверно, повторите попытку: ");
                        s = in.nextLine();
                    }
                }
            }
        } catch (NumberFormatException e) {
            while (s.equals("") || bool) {
                try {
                    nop = Integer.parseInt(s);
                    if (nop < 1) {
                        s = in.nextLine();
                        continue;
                    }
                    bool = false;
                } catch (NumberFormatException e1) {
                    System.out.println("Координата введена неверно, повторите попытку: ");
                    s = in.nextLine();
                }
            }
        }

        //establishmentDate
        System.out.println("Введите дату создания: ");
        LocalDate date = LocalDate.now();
        s = in.nextLine();
        int day;
        int month;
        int year;
        bool = true;
        String[] dat = s.split("-");
        if (s.equals("")){
            date = null;
        }
        else{
            try {
                day = Integer.parseInt(dat[0]);
                month = Integer.parseInt(dat[1]);
                year = Integer.parseInt(dat[2]);
                date = LocalDate.of(day,month,year);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | DateTimeException e) {
                while (bool) {
                    try {
                        day = Integer.parseInt(dat[0]);
                        month = Integer.parseInt(dat[1]);
                        year = Integer.parseInt(dat[2]);
                        date = LocalDate.of(year,month,day);
                        bool = false;
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException | DateTimeException f) {
                        System.out.println("Дата создания введена неверно, повторите попытку");
                        s = in.nextLine();
                        dat = s.split("-");
                    }
                }
            }
        }

        //MusicGenre
        System.out.println("Введите жанр(JAZZ, BLUES, MATH_ROCK, K_POP): ");
        MusicGenre genre = null;
        s = in.nextLine();
        bool = true;
        if (s.equals("")){
            genre = null;
        }
        else {
            try {
                genre = MusicGenre.valueOf(s);
            } catch (IllegalArgumentException e) {
                while (bool) {
                    try {
                        genre = MusicGenre.valueOf(s);
                        bool = false;
                    } catch (IllegalArgumentException f) {
                        System.out.println("Жанр введен неверно, повторите попытку");
                        s = in.nextLine();
                    }
                }
            }
        }

        //frontmans's name
        System.out.println("Введите имя лидера группы: ");
        String frname = in.nextLine();
        if (frname.equals("")) {
            while (frname.equals("")) {
                System.out.println("Введите корректное имя: ");
                frname = in.nextLine();
            }
        }

        //height
        System.out.println("Введите рост лидера группы: ");
        bool = true;
        Double height = 0D;
        s = in.nextLine();
        try {
            height = Double.valueOf(s);
            if (height < 1) {
                while (s.equals("") || bool) {
                    try {
                        height = Double.valueOf(s);
                        if (height < 1) {
                            s = in.nextLine();
                            continue;
                        }
                        bool = false;
                    } catch (NumberFormatException e1) {
                        System.out.println("Рост введен неверно, повторите попытку: ");
                        s = in.nextLine();
                    }
                }
            }
        } catch (NumberFormatException e) {
            while (s.equals("") || bool) {
                try {
                    height = Double.valueOf(s);
                    if (height < 1) {
                        s = in.nextLine();
                        continue;
                    }
                    bool = false;
                } catch (NumberFormatException e1) {
                    System.out.println("Рост введен неверно, повторите попытку: ");
                    s = in.nextLine();
                }
            }
        }

        //eyeColor
        System.out.println("Введите цвет глаз(GREEN, BLUE, ORANGE, WHITE, BLACK, BROWN): ");
        Color eyeColor = null;
        s = in.nextLine();
        bool = true;
        if (s.equals("")) {
            try {
                eyeColor = Color.valueOf(s);
            } catch (IllegalArgumentException e) {
                while (bool) {
                    try {
                        eyeColor = Color.valueOf(s);
                        bool = false;
                    } catch (IllegalArgumentException f) {
                        System.out.println("Цвет введен неверно, повторите попытку");
                        s = in.nextLine();
                    }
                }
            }
        }

        //hairColor
        System.out.println("Введите цвет волос(GREEN, BLUE, ORANGE, WHITE, BLACK, BROWN): ");
        Color hairColor = null;
        s = in.nextLine();
        bool = true;
        if (s.equals("")) {
            hairColor = null;
        }
        else {
            try {
                hairColor = Color.valueOf(s);
            } catch (IllegalArgumentException e) {
                while (bool) {
                    try {
                        hairColor = Color.valueOf(s);
                        bool = false;
                    } catch (IllegalArgumentException f) {
                        System.out.println("Цвет введен неверно, повторите попытку");
                        s = in.nextLine();
                    }
                }
            }
        }

        //nationality
        System.out.println("Введите страну(FRANCE, THAILAND, ITALY, SOUTH_KOREA, NORTH_KOREA): ");
        Country nat = null;
        s = in.nextLine();
        bool = true;
        if (s.equals("")) {
            nat = null;
        }
        else {
            try {
                nat = Country.valueOf(s);
            } catch (IllegalArgumentException e) {
                while (bool) {
                    try {
                        nat = Country.valueOf(s);
                        bool = false;
                    } catch (IllegalArgumentException f) {
                        System.out.println("Страна введена неверно, повторите попытку: ");
                        s = in.nextLine();
                    }
                }
            }
        }

        return new MusicBand(name, new Coordinates(x, y), nop, date, genre, new Person(frname, height, eyeColor, hairColor, nat));
    }

    public static File getStartFile() {
        return startFile;
    }
}
