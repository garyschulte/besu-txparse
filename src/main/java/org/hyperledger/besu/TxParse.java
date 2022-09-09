package org.hyperledger.besu;

import org.hyperledger.besu.ethereum.core.encoding.TransactionDecoder;

import java.io.IOException;

import org.apache.tuweni.bytes.Bytes;

public class TxParse {
  public static void main(String args[]) {
    try {
      dump(Bytes.fromHexString(new String(System.in.readAllBytes()).trim()));
    } catch(IOException ioex) {
      System.err.println("IO exception.  Example usage: \n\techo \"0x02...\" | besu-txparse");
    }
  }
  public static void dump(Bytes tx) {
    try {
      System.out.println(
          TransactionDecoder.decodeOpaqueBytes(tx)
              .getSender().toString()
      );
    } catch(Exception ex) {
      System.out.println("err: " + ex.getMessage());
    }
  }

  public static void test() {
    dump(Bytes.fromHexString("0x02f875018363bc5a8477359400850c570bd200825208943893d427c770de9b92065da03a8c825f13498da28702fbf8ccf8530480c080a0dd49141ecf93eeeaed5f3499a6103d6a9778e24a37b1f5c6a336c60c8a078c15a0511b51a3050771f66c1b779210a46a51be521a2446a3f87fc656dcfd1782aa5e"));
  }
}
