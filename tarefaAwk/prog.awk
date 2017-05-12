BEGIN { 
	print "Nome - Situação"
	count = 0
	apr = 0
	exame = 0
	repr = 0
	reprf = 0
	reprn = 0
}
{
	split($0, a, " - ")
	if(a[2] < 60) { 
		print a[1] " - Reprovado por frequencia";
		repr+=1
		reprf+=1
	}
	else {
		mp = (a[3] + a[4]) / 2
		mt = (a[5] + a[6]) / 2
		m = (mp + mt) / 2
		if(m > 7){
			print a[1] " - Aprovado"
			apr+=1
		}
		else {
			if( m >= 3 && m < 7){
				print a[1] " - Fazer exame: necessita tirar " (10 - m)
				exame+=1
			}
			else {
				print a[1] " - Reprovado, sem direito a exame" 
				repr+=1
				reprn+=1
			}
		}
	}
	count+=1
}
END{
	print "Foram lidos " count " alunos."
	str = apr > 1 ? " Foram aprovados" : " Foi aprovado"
	print apr str
	print exame " ficaram em exame" 
	print repr " foram reprovados ", reprf " por frequencia e " reprn " por nota baixa"
}