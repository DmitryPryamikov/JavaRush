package com.javarush.test.level20.lesson02.task02;

        import java.io.*;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            //File your_file_name = new File("D:\\s.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy",Locale.ENGLISH);
            //

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("John");
            user1.setLastName("Smith");
            user1.setBirthDate(sdf.parse("25.06.1985"));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            //
            javaRush.users.add(user1);
            //
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            //
            SimpleDateFormat format1= new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            PrintWriter writer = new PrintWriter(outputStream);
            for (User u:users)
            {
                writer.println(u.getFirstName());
                writer.println(u.getLastName());
                writer.println(format1.format(u.getBirthDate()));
                writer.println(u.isMale());
                writer.println(u.getCountry().getDisplayedName());
            }
            //
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";

            while ((line = reader.readLine())!=null)
            {
                User _user = new User();

                _user.setFirstName(line);
                _user.setLastName(reader.readLine());
                Date getDate = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(reader.readLine());
                _user.setBirthDate(getDate);
                _user.setMale(Boolean.parseBoolean(reader.readLine()));
                String country = reader.readLine();
                switch (country) {
                    case "Ukraine":
                        _user.setCountry(User.Country.UKRAINE);

                        break;
                    case "Russia":
                        _user.setCountry(User.Country.RUSSIA);
                        break;

                    default:
                        _user.setCountry(User.Country.OTHER);
                        break;
                }
                this.users.add(_user);
            }
            //

            reader.close();
        }
    }
}
