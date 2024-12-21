package kafka.protocol.io;

import java.nio.ByteBuffer;

import lombok.SneakyThrows;

public class DataByteBuffer implements DataInput {

	private final ByteBuffer delegate;

	public DataByteBuffer(ByteBuffer buffer) {
		this.delegate = buffer;
	}

	@SneakyThrows
	public ByteBuffer readNBytes(int n) {
		final var bytes = new byte[n];

		delegate.get(bytes, 0, bytes.length);

		return ByteBuffer.wrap(bytes);
	}

	@SneakyThrows
	@Override
	public byte readByte() {
		return delegate.get();
	}

	@SneakyThrows
	@Override
	public short readSignedShort() {
		return delegate.getShort();
	}

	@SneakyThrows
	@Override
	public int readSignedInt() {
		return delegate.getInt();
	}

}