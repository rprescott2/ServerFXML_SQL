package sample;



import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;

import java.net.Socket;
import java.nio.ByteBuffer;


class ServerSomthing extends Thread{
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    DataBase dataBase = new DataBase();
    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String login;
        String password;
        String word;
        try {
            while (true) {
                word = in.readLine();
                if(word.contains("okey")) {
                    String key = in.readLine();
                    if (dataBase.check(key) == true){
                        out.write("true" + "\n");
                        out.flush();
                        OutputStream outputStream = socket.getOutputStream();
                        BufferedImage image = ImageIO.read(new File("C:\\ng2019-krim-0.jpg"));
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        ImageIO.write(image, "jpg", byteArrayOutputStream);
                        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
                        outputStream.write(size);
                        outputStream.write(byteArrayOutputStream.toByteArray());
                        outputStream.flush();
                        break;
                    }
                    else if (dataBase.check(key) == false) {
                        out.write("false" + "\n");
                        out.flush();
                        break;
                    }
                } else if(word.equals("Admin")) {
                     login = in.readLine();
                     password = in.readLine();
                    if (dataBase.administrator.containsKey(login)) {
                        if (dataBase.administrator.get(login).equals(password)) {
                            out.write("true" + "\n");
                            out.flush();
                            String adminAdd = in.readLine();
                            while (adminAdd.equals("Add")) {
                                String read = in.readLine();
                                System.out.println(read);
                                dataBase.write(read);
                                adminAdd = in.readLine();

                            }
                            if (adminAdd.equals("Back")) {
                                socket.close();
                                break;
                            }
                        } else {
                            out.write("false" + "\n");
                            out.flush();
                            socket.close();
                            break;
                        }
                    } else {
                        out.write("false" + "\n");
                        out.flush();
                        socket.close();
                        break;
                    }
                }
            }

        } catch (IOException e) {
        }
    }
}