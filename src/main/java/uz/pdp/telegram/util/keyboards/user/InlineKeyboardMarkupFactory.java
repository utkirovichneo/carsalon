package uz.pdp.telegram.util.keyboards.user;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import uz.pdp.back.model.basemodel.BaseModel;

import java.util.List;


public class InlineKeyboardMarkupFactory extends Keyboard {

    public static <T extends BaseModel>InlineKeyboardMarkup listInlineButtons(List<T> list) {
        InlineKeyboardButton [][] buttons = new InlineKeyboardButton[list.size()/2][2];
        for (int i = 0; i < list.size() / 2; i++) {
        InlineKeyboardButton button1 = new InlineKeyboardButton(list.get(2*i).forCallbackButton());
        button1.callbackData(list.get(2*i).getId());
        InlineKeyboardButton button2 = new InlineKeyboardButton(list.get(2*i+1).forCallbackButton());
        button2.callbackData(list.get(2*i+1).getId());
        buttons[i][0] = button1;
        buttons[i][1] = button2;
        }
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup(buttons);
        if(list.size()%2!=0){
            InlineKeyboardButton button = new InlineKeyboardButton(list.get(list.size()-1).forCallbackButton());
            button.callbackData(list.get(list.size() - 1).forCallbackButton());
            inlineKeyboardMarkup.addRow(button);
        }
        return inlineKeyboardMarkup;
    }
    public static InlineKeyboardMarkup backOrOrderButton(){
        InlineKeyboardButton[][] buttons = new InlineKeyboardButton[1][2];
        InlineKeyboardButton button1 = new InlineKeyboardButton("Orqaga");
        InlineKeyboardButton button2 = new InlineKeyboardButton("Shartnoma olish");
        button1.callbackData("back");
        button2.callbackData("shartnoma");
        buttons[0][0] = button1;
        buttons[0][1] = button2;
        return new InlineKeyboardMarkup(buttons);
    }
    public static InlineKeyboardMarkup orderButton(){
        InlineKeyboardButton button = new InlineKeyboardButton("Shartnoma olish");
        button.callbackData("shartnoma");
        return new InlineKeyboardMarkup(button);
    }
}