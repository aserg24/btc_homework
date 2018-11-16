package crypto.transactions;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.crypto.TransactionSignature;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptBuilder;

import java.io.File;

import static org.bitcoinj.script.ScriptOpCodes.OP_CHECKSIG;
import static org.bitcoinj.script.ScriptOpCodes.OP_DUP;
import static org.bitcoinj.script.ScriptOpCodes.OP_HASH160;
import static org.bitcoinj.script.ScriptOpCodes.OP_EQUALVERIFY;

public class PayToPubKeyHash extends ScriptTransaction {
    // TODO: Задание 1

    public PayToPubKeyHash(NetworkParameters parameters, File file, String password) {
        super(parameters, file, password);
    }

    @Override
    public Script createInputScript() {
        // TODO: Создайте P2PKH-скрипт
        ScriptBuilder builder = new ScriptBuilder();
        builder.data("1ashidVK7yogewX6NsDhu1RwCfmvj3BNf".getBytes());
        builder.op(OP_DUP).op(OP_HASH160).op(OP_EQUALVERIFY).op(OP_CHECKSIG);
        return builder.build();
    }

    @Override
    public Script createRedemptionScript(Transaction unsignedTransaction) {
        // TODO: Потратьте деньги с этой P2PKH-транзакции
        return null;
    }
}
