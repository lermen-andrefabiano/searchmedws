package br.com.searchmed.tarefa;

import javax.inject.Named;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

@Named
public class AgendadorHorarioMedico{

	public void inicia() throws Exception {
		// Detalhes da tarefa
		JobDetail job = JobBuilder.newJob(TarefaHorarioMedico.class).withIdentity("tarefaAgendadorHorarioMedico", "groupAgendadorHorarioMedico").build();
		// Gatilho - ou seja, quando irá chamar, neste caso, a cada 5 segundos
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("gatilhoAgendadorHorarioMedico", "groupAgendadorHorarioMedico")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?")).build();
		//.withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(DateBuilder.WEDNESDAY, 23, 00)).build(); 
		//.withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(DateBuilder.SATURDAY, 23, 00)).build(); 
						//.cronSchedule("0/60 * * * * ?")).build();

		// Agenda e voa lá!
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
		
	}

}
