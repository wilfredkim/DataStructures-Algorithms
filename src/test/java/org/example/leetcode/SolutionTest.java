package org.example.leetcode;

import org.example.algorithms.Algorithms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solutionTest;

    @BeforeEach
    void setUp() {
        solutionTest = new Solution();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void replaceWord() {
        String word1 = "LocalTxnDtTime=2022-11-18T14:53:50~*STAN=AAAAB2763A22~*SystemCode=OMNISACCO~*TransactionReference=AAAAB2763A22~*TransactionDate=2022-11-18T14:53:50~*SourceChannel=OMNISACCO~*SaccoID=42993375~*EnquiryType=TRANSFER~*Encyrption=1~*MaxNumberOfRows=0~*OriginalMessageID=~*TransactionCode=AS6~*TransactionType=AS6~*MobileNumber=0717663099~*DebitAccount=101102234622001~*CreditAccount=0717663099~*TransactionAmount=100.00~*TransactionCurrency=KES~*ChargeAccount=01100342565002~*ChargeAmount=0~*ChargeCurrency=KES~*FeeAccount=01130270011250~*FeeAmount=0~*FeeCurrency=KES~*Narrative1=AAAAB2763A22 Transfer to Mpesa 0717663099 101102234622001 werrerewrew~*Narrative2=AAAAB2763A22 Transfer to Mpesa 0717663099 101102234622001 werrerewrew~*InstitutionCode=42993375~*Key=partnerFeeTransactionCode~*Value=AS8~*Key=partnerFeeAmount~*Value=0~*Key=partnerSuspenseAccount~*Value=01130270011250~*hdr_Tran_Id=COOP_IFT_TRANSFERS_SACCO~*LocalTxnDtTime=2022-11-18T14:53:50~*CorrelationID=AAAAB2763A22~*FaultTO=AAAAB2763A22~*STAN=AAAAB2763A22~*ReplyTO=http~*Username=OMNI~*Password=omni~*Realm=http~*MessageType=NORMAL~*OperationType=Account~*UserID=3~*ValueDate=2022-11-18T14:53:50~*FromCurrency=KES~*ExchangeRate=1~*ExchangeRateFlag=M~*ToCurrency=KES~*TransactionItemKey=AAAAB2763A22-01~*AccountNumber=01100342565002~*DebitCreditFlag=D~*TransactionAmount=100.00~*TransactionCurrency=KES~*TransactionReference=AAAAB2763A22~*Narrative=AAAAB2763A22 Transfer to Mpesa 0717663099 101102234622001 werrerewrew~*BaseEquivalent=100.00~*SourceBranch=096~*TransactionCode=AS6~*TransactionItemKey=AAAAB2763A22-04~*AccountNumber=01130270011250~*DebitCreditFlag=C~*TransactionAmount=100.00~*TransactionCurrency=KES~*TransactionReference=AAAAB2763A22~*Narrative=AAAAB2763A22 Transfer to Mpesa 0717663099 101102234622001 werrerewrew~*BaseEquivalent=100.00~*SourceBranch=096~*TransactionCode=AS6~*EventType=TRANF~*EventId=MPESA_SACCO~*ChargeAccountSerial=AAAAB2763A22-01~*";
        String word2 = "LocalTxnDtTime=2022-11-18T14:53:50~*STAN=CB0000522_20221119~*SystemCode=OMNISACCO~*TransactionReference=AAAAB2763A22~*TransactionDate=2022-11-18T14:53:50~*SourceChannel=OMNISACCO~*SaccoID=42993375~*EnquiryType=TRANSFER~*Encyrption=1~*MaxNumberOfRows=0~*OriginalMessageID=AAAAB2763A22~*TransactionCode=AS6~*TransactionType=AS6~*MobileNumber=0717663099~*DebitAccount=101102234622001~*CreditAccount=0717663099~*TransactionAmount=100.00~*TransactionCurrency=KES~*ChargeAccount=01100342565002~*ChargeAmount=0~*ChargeCurrency=KES~*FeeAccount=01130270011250~*FeeAmount=0~*FeeCurrency=KES~*Narrative1=AAAAB2763A22 Transfer to Mpesa 0717663099 101102234622001 werrerewrew~*Narrative2=AAAAB2763A22 Transfer to Mpesa 0717663099 101102234622001 werrerewrew~*InstitutionCode=42993375~*Key=partnerFeeTransactionCode~*Value=AS8~*Key=partnerFeeAmount~*Value=0~*Key=partnerSuspenseAccount~*Value=01130270011250~*hdr_Tran_Id=COOP_IFT_TRANSFERS_SACCO~*LocalTxnDtTime=2022-11-18T14:53:50~*CorrelationID=AAAAB2763A22~*FaultTO=AAAAB2763A22~*STAN=AAAAB2763A22~*ReplyTO=http~*Username=OMNI~*Password=omni~*Realm=http~*MessageType=REVERSAL~*OperationType=Account~*UserID=3~*ValueDate=2022-11-18T14:53:50~*FromCurrency=KES~*ExchangeRate=1~*ExchangeRateFlag=M~*ToCurrency=KES~*TransactionItemKey=AAAAB2763A22-01~*AccountNumber=01100342565002~*DebitCreditFlag=D~*TransactionAmount=100.00~*TransactionCurrency=KES~*TransactionReference=AAAAB2763A22~*Narrative=AAAAB2763A22 Transfer to Mpesa 0717663099 101102234622001 werrerewrew~*BaseEquivalent=100.00~*SourceBranch=096~*TransactionCode=AS6~*TransactionItemKey=AAAAB2763A22-04~*AccountNumber=01130270011250~*DebitCreditFlag=C~*TransactionAmount=100.00~*TransactionCurrency=KES~*TransactionReference=AAAAB2763A22~*Narrative=AAAAB2763A22 Transfer to Mpesa 0717663099 101102234622001 werrerewrew~*BaseEquivalent=100.00~*SourceBranch=096~*TransactionCode=AS6~*EventType=TRANF~*EventId=MPESA_SACCO~*ChargeAccountSerial=AAAAB2763A22-01~*";
        assertEquals(word2, solutionTest.replaceWord(word1, "CB0000522_20221119"));

    }

    @Test
    void sortArray() {
        assertEquals(2, solutionTest.sortArray(new int[]{3,2,1,3,2,3}));

    }
}