package br.com.yanaga.web;

import java.util.Map;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum Board {

	MINNOW("i386", "http://192.168.1.12:8080/things/blue/255", "http://192.168.1.12:8080/things/blue/0"), //
	RASPI("arm", "http://192.168.1.12:8080/things/red/255", "http://192.168.1.12:8080/things/red/0");

	private static final Map<String, Board> archMap;

	static {
		Builder<String, Board> builder = ImmutableMap.builder();
		for (Board board : values()) {
			builder.put(board.arch, board);
		}
		archMap = builder.build();
	}

	public static Board fromString(String value) {
		return Objects.firstNonNull(archMap.get(value), Board.MINNOW);
	}

	private final String arch;

	private final String ligar;

	private final String desligar;

	private Board(String arch, String ligar, String desligar) {
		this.arch = arch;
		this.ligar = ligar;
		this.desligar = desligar;
	}

	public String getLigar() {
		return ligar;
	}

	public String getDesligar() {
		return desligar;
	}

}