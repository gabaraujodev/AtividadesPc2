/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baralho1;


public class Carta {
  private int valor;
  private String naipe;
  
  public Carta() {
      this.valor = 0;
      this.naipe = " ";
  }
  
  public Carta(int valor, String naipe) {
      this.valor = valor;
      this.naipe = naipe;
  }
  
  public int compara(Carta outraCarta) {
      if (this.valor > outraCarta.valor) {
          return 1;
      } else if (this.valor == outraCarta.valor) {
          return 0;
      } else {
          return -1;
      }
  }
  
  public boolean mesmoNaipe(Carta outraCarta) {
      return this.naipe.equals(outraCarta.naipe);
  }
}