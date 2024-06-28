package game;

import jogador.Jogador;
import itens.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Save {
    private static final String SAVE_FILE = "save.txt";

    public static void save(Jogador jogador) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {
            writer.write(jogador.getHP() + "\n");
            writer.write(jogador.getSanidade() + "\n");
            writer.write(jogador.getDano() + "\n");
            for (Item item : jogador.getInventario()) {
                writer.write(item.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jogador load() {
        Jogador jogador = new Jogador();
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            jogador.setHP(Integer.parseInt(reader.readLine()));
            jogador.setSanidade(Integer.parseInt(reader.readLine()));
            jogador.setDano(Integer.parseInt(reader.readLine()));
            String line;
            List<Item> inventario = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                inventario.add(Item.fromString(line));
            }
            jogador.setInventario(inventario);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jogador;
    }
}