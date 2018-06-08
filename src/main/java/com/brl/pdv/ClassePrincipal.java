package com.brl.pdv;

import java.awt.EventQueue;

import com.brl.pdv.view.JanelaInicial;

public class ClassePrincipal {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaInicial janelaInicial = new JanelaInicial();
                janelaInicial.setVisible(true);
            }
        });
    }
}
