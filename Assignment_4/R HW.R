##Import data

train <- read.csv("~/Desktop/train.csv",header=T)

##Check Missing Data
any(is.na(train))
##inport library ggplot2
library(ggplot2)
##Delete invalid items
newtrain <- train[!(train$Age==""), ]

##Whisker-plot

boxplot(Age~Survived, data=newtrain, main="Whisker-plot", xlab="Survived", ylab="Age", col=(c("gold","darkgreen")))

##Histogram + Facet

ggplot(newtrain,aes(Age))+geom_histogram(aes(fill = Survived), binwidth=5, color="green")+facet_grid(.~Pclass)

##Violin

ggplot(newtrain,aes(factor(Survived),Age))+geom_violin()

##Heatmap
newtrain<-newtrain[1:15,]
train_matrix<-data.matrix(newtrain)
heatmap(train_matrix, main = "Correlation", notecol="black", density.info="none", trace="none", margins =c(12,9), col=my_palette, breaks=col_breaks, dendrogram="row", Colv="NA")      



