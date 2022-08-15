package me.infinity.hypixelapi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.PlayerReply;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class Main {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    HypixelAPI api = new HypixelAPI(UUID.fromString("Your-Key"));
    PlayerReply player = api.getPlayerByName("HypixelPlayer").get();

    Optional<JsonElement> jsonObject = Optional.ofNullable(player.getPlayer().get("stats").getAsJsonObject().get("Bedwars").getAsJsonObject().get("favourites_2"));
    if (jsonObject.isEmpty()) {
      System.out.println("That player doesn't have quickshop setuped.");
      return;
    }

    System.out.println(jsonObject.get().getAsString());
  }
}
