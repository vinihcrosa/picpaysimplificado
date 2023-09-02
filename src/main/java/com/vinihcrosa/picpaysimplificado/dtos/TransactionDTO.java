package com.vinihcrosa.picpaysimplificado.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, long senderId, long receiverId){
}
