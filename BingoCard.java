import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BingoCard {
	
	private BingoTile[][] tiles = new BingoTile[5][5];
	
	public BingoCard() {
		generateTiles();
	}
	
	private void generateTiles() {
		
		List<Integer> banks0 = new ArrayList<>(15);
		List<Integer> banks1 = new ArrayList<>(15);
		List<Integer> banks2 = new ArrayList<>(15);
		List<Integer> banks3 = new ArrayList<>(15);
		List<Integer> banks4 = new ArrayList<>(15);
		
		for(int i = 1; i <= 15; i++) {
			banks0.add(i);
			banks1.add(i+15);
			banks2.add(i+15*2);
			banks3.add(i+15*3);
			banks4.add(i+16*4);
			
		}
		
		BingoTile middle = new BingoTile(-1);
		middle.setCrossedOff(true);
		tiles[2][2] = middle;
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks0.size());
			int number = banks0.get(place);
			banks0.remove(place);
			BingoTile tile = new BingoTile(number);
			tiles[0][i] = tile;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks1.size());
			int number = banks1.get(place);
			banks1.remove(place);
			BingoTile tile = new BingoTile(number);
			tiles[1][i] = tile;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks2.size());
			int number = banks2.get(place);
			banks2.remove(place);
			BingoTile tile = new BingoTile(number);
			tiles[2][i] = tile;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks3.size());
			int number = banks3.get(place);
			banks3.remove(place);
			BingoTile tile = new BingoTile(number);
			tiles[3][i] = tile;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks4.size());
			int number = banks4.get(place);
			banks4.remove(place);
			BingoTile tile = new BingoTile(number);
			tiles[4][i] = tile;
		}
		
	}
	
	private static Random random;
	
	public static void createRandom(long seed) {
		random = new Random(seed);
	}
	
	private static int getWithinRange(int row) {
		int number = random.nextInt(15) + 1;
		return number + (row * 15);
	}
	
	public BingoTile getTile(int x, int y) {
		return tiles[x][y];
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int row = 0; row < 5; row++){
			for (int col = 0; col < 5; col++) {
				builder.append(tiles[row][col].getValue()).append('\t');
			}
			builder.append('\n');
		}
		return builder.toString();
	}
}
