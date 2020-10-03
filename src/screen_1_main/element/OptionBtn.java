package screen_1_main.element;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import common.static_data.Size;
import interfaces.element.Button;

public class OptionBtn implements Button {
	private int x = Size.FRAME_W / 8 * 3;
	private int y = Size.FRAME_H / 6 + 300;
	private int w = Size.FRAME_W / 4;
	private int h = Size.FRAME_H / 10;
	private Image img = null;

	public OptionBtn() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/option_btn_normal.png");
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.drawImage(img, x, y, w, h, null);
	}

	@Override
	public void focus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/option_btn_select.png");
	}

	@Override
	public void unfocus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/option_btn_normal.png");
	}

	@Override
	public void doAction() {
		System.out.println("option버튼 실행");
	}


}
