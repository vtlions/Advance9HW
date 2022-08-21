package com.vtlions.HWmultithreading;

import java.util.List;

public class IdSender implements Runnable {

	private List<Integer> idList;
	private IdConsumer idConsumer;
	private int i = 0;

	public IdSender(List<Integer> idList, final IdConsumer idConsumer) {
		this.idList = idList;
		this.idConsumer = idConsumer;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (i < 1000000) {
			idConsumer.setId(idList.get(0));
			idList.remove(0);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}
