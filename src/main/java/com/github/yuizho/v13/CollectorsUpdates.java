package com.github.yuizho.v13;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsUpdates {
    public static void main(String... args) {
        // https://qiita.com/nowokay/items/3e1625a77cb435394547#mapof%E3%81%A7%E8%A6%81%E7%B4%A0%E6%95%B01%E3%81%AEmap%E3%81%AB%E5%AF%BE%E3%81%99%E3%82%8Bgetnull%E3%81%8C%E3%81%AC%E3%82%8B%E3%81%BD
        // Map.of().getg(null)で12までnullが帰っていたが、13からNPEになる
        Map.of().get(null);
    }
}
