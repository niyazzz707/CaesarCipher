package com.example.cipher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.text.Text;

public class CipherController {
    @FXML
    private Text alignText;

    @FXML
    private Button buttonDecrypt;

    @FXML
    private Button buttonEncrypt;

    @FXML
    private TextField originalTextField;

    @FXML
    private TextField shiftField;

    @FXML
    void keyFieldClicked(MouseEvent event) {
    alignText.setText("");
    }

    @FXML
    void textFieldClicked(MouseEvent event) {
    alignText.setText("");
    }


    @FXML
    void decryptBtnOnActive(ActionEvent event) {

     try {
         String text = originalTextField.getText();
         int shift = Integer.parseInt(shiftField.getText());
         decryptText(text,shift);
     }
     catch (NumberFormatException e) {
         alignText.setText("Please, write it in the correct format!");
     }

    }

    @FXML
    void encryptBtnOnActive(ActionEvent event) {

        try {
            String text = originalTextField.getText();
            int shift = Integer.parseInt(shiftField.getText());

            encryptText(text, shift);
        }
        catch (NumberFormatException e) {
            alignText.setText("Please, write it \nin the correct format");
        }

    }

    public void encryptText(String text, int shift) {
        String encryptText = "";

        for(int i=0; i < text.length();i++)
        {

            char alphabet = text.charAt(i);

            if(alphabet >= 'a' && alphabet <= 'z') {

                alphabet = (char) (alphabet + shift);

                if(alphabet > 'z') {

                    alphabet = (char) (alphabet+'a'-'z'-1);
                }
                encryptText = encryptText + alphabet;
            }

            else if(alphabet >= 'A' && alphabet <= 'Z') {

                alphabet = (char) (alphabet + shift);


                if(alphabet > 'Z') {

                    alphabet = (char) (alphabet+'A'-'Z'-1);
                }
                encryptText = encryptText + alphabet;
            }

            else {
                encryptText = encryptText + alphabet;
            }
        }
        alignText.setText("Encrypted text: \n" + encryptText);
    }

    public void decryptText(String text, int shift) {
        String decryptText = "";

        for(int i=0; i < text.length();i++) {

            char alphabet = text.charAt(i);

            if(alphabet >= 'a' && alphabet <= 'z') {

                alphabet = (char) (alphabet - shift);

                if(alphabet < 'a') {

                    alphabet = (char) (alphabet-'a'+'z'+1);
                }
                decryptText = decryptText + alphabet;
            }

            else if(alphabet >= 'A' && alphabet <= 'Z') {

                alphabet = (char) (alphabet - shift);


                if (alphabet < 'A') {

                    alphabet = (char) (alphabet-'A'+'Z'+1);
                }
                decryptText = decryptText + alphabet;
            }

            else {
                decryptText = decryptText + alphabet;
            }
        }
        alignText.setText("Decrypted text: \n" + decryptText);
    }
}