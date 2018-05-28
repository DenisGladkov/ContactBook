package com.gladkov.javaphonebook.dao.impl;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileSystemContactDaoImpl implements ContactDao {

    /**
     * Сервис работы с файловой системой. Преобразует модели в/из данные хранимые на жестком диске.
     */

    private static final File FILE = new File("data");
    private List<Contact> list;
    

    /*public FileSystemContactDaoImpl()  {
        if (!FILE.exists()) {
            System.out.println("boroda");
        }

    }*/
    public FileSystemContactDaoImpl() {
    }


        //TODO исправить логику так, что бы файл не пересоздавался а дополнялся.
        @Override
       /* public void saveContact (Contact contact){
            try (PrintStream printStream = new PrintStream(new FileOutputStream(FILE, true), true)) {
                printStream.println(contact);
                printStream.println(contact);
                printStream.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }*/
        public void saveContact(Contact contact) {
            try (PrintWriter writer = new PrintWriter(
                    new BufferedWriter(new FileWriter(FILE)))) {
                writer.println(contact);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void removeContact(String lineToRemove) {

        try {

            File inFile = new File(String.valueOf(FILE));

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(FILE));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

        public List<Contact> showAll () {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                return new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }


    }
