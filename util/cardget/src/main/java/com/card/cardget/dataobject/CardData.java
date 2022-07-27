package com.card.cardget.dataobject;

import lombok.Data;

@Data
public class CardData {
    int id;
    int cardId;
    int rule;
    byte[] setname;
    byte[] data2;
    byte[] type;
    String atk;
    String def;
    byte[] level;
    byte[] zz;
    byte[] category;
    byte[] attribute;
}
