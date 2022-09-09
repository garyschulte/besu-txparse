# Besu TxParse

Simple cli tool to parse a transaction from stdin and return the sender, or an error.  

### Build
`./gradlew install`

### Run
`echo "0x02..." |build/install/besu-txparse/bin/besu-txparse`
