package interfaces;

import java.util.ArrayList;

import entity.HoaDon;

public interface IHoaDon {
	ArrayList<HoaDon> getAllHoaDon() throws Exception;
	boolean taoHoaDon(HoaDon hd);
}
