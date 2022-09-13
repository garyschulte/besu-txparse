package org.hyperledger.besu;

import org.hyperledger.besu.ethereum.core.encoding.TransactionDecoder;

import java.io.*;
import java.util.Scanner;

import org.apache.tuweni.bytes.Bytes;

public class TxParse {
  public static void main(String args[]) {
    doit(System.in);
  }

  public static void doit(InputStream src){
    var sc = new Scanner(src);
    while(sc.hasNext()){
      try {
        var tx = Bytes.fromHexString(sc.nextLine().trim());
        System.out.println(TransactionDecoder.decodeOpaqueBytes(tx).getSender());
      } catch (Exception ex) {
        System.out.println("err: " + ex.getMessage());
      }
    }
  }

  public static void test() {
    var testdata = "test\n" +
            "monkey\n" +
            "0x1\n" +
            "0x112391201239129312392139123 123 12 312 312 3\n" +
            "0xdead\n" +
            "0xf8d2b86702f864010180820fa08284d09411111111111111111111111111111111111111118080c001a0b7dfab36232379bb3d1497a4f91c1966b1f932eae3ade107bf5d723b9cb474e0a06261c359a10f2132f126d250485b90cf20f30340801244a08ef6142ab33d1904b86702f864010280820fa08284d09411111111111111111111111111111111111111118080c080a0d4ec563b6568cd42d998fc4134b36933c6568d01533b5adf08769270243c6c7fa072bf7c21eac6bbeae5143371eef26d5e279637f3bd73482b55979d76d935b1e9\n" +
            "02f864010180820fa08284d09411111111111111111111111111111111111111118080c001a0b7dfab36232379bb3d1497a4f91c1966b1f932eae3ade107bf5d723b9cb474e0a06261c359a10f2132f126d250485b90cf20f30340801244a08ef6142ab33d1904\n" +
            "0x02f864010180820fa08284d09411111111111111111111111111111111111111118080c001a0b7dfab36232379bb3d1497a4f91c1966b1f932eae3ade107bf5d723b9cb474e0a06261c359a10f2132f126d250485b90cf20f30340801244a08ef6142ab33d1904\n" +
            "deadest\n";
    var in = new ByteArrayInputStream(testdata.getBytes());
    doit(in);
  }
}
