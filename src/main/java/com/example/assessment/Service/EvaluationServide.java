package com.example.assessment.Service;

import com.example.assessment.Entity.Evaluation;
import com.example.assessment.Repository.EvaluationRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EvaluationServide {

	private final EvaluationRepo repo;

	public EvaluationServide(EvaluationRepo repo) {
		this.repo = repo;
	}

	public Evaluation add(Evaluation evaluation) {
		return repo.save(evaluation);
	}

	public Optional<EvaluationSummary> evaluate(Long id) {
		return repo.findById(id).map(e -> {
			int m1 = safe(e.getMark1());
			int m2 = safe(e.getMark2());
			int m3 = safe(e.getMark3());
			int total = m1 + m2 + m3;
			double percent = total / 3.0;
			return new EvaluationSummary(total, percent);
		});
	}

	private int safe(Integer v) {
		return v == null ? 0 : v;
	}

	public static class EvaluationSummary {
		private final int total;
		private final double percent;

		public EvaluationSummary(int total, double percent) {
			this.total = total;
			this.percent = percent;
		}

		public int getTotal() {
			return total;
		}

		public double getPercent() {
			return percent;
		}
	}
}
