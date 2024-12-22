package kafka.protocol;

import kafka.protocol.io.DataOutput;

public record Response(
	Header header,
	ResponseBody body
) {
	
	public void serialize(DataOutput output) {
		header.serialize(output);
		body.serialize(output);
	}
	
}